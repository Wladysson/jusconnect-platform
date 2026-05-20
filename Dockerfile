# =========================================================
# Stage 1 - Build da aplicação
# =========================================================
FROM eclipse-temurin:17-jdk AS builder

WORKDIR /build

# Copia arquivos do Maven primeiro
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Permissão do Maven Wrapper
RUN chmod +x mvnw

# Baixa dependências para aproveitar cache
RUN ./mvnw dependency:go-offline -B

# Copia código-fonte
COPY src src

# Build da aplicação Quarkus
RUN ./mvnw clean package -DskipTests


# =========================================================
# Stage 2 - Runtime leve
# =========================================================
FROM eclipse-temurin:17-jre

WORKDIR /app

# Metadados
LABEL maintainer="JusConnect Platform"
LABEL application="jusconnect-platform"

# Copia apenas os artefatos necessários
COPY --from=builder /build/target/quarkus-app/lib/ /app/lib/
COPY --from=builder /build/target/quarkus-app/*.jar /app/
COPY --from=builder /build/target/quarkus-app/app/ /app/app/
COPY --from=builder /build/target/quarkus-app/quarkus/ /app/quarkus/

# Porta da aplicação
EXPOSE 8080

# Configurações JVM
ENV JAVA_OPTS="-Dquarkus.http.host=0.0.0.0 \
-Xms256m \
-Xmx512m"

# Healthcheck do Quarkus
HEALTHCHECK --interval=30s --timeout=10s --start-period=40s --retries=3 \
CMD wget --spider -q http://localhost:8080/q/health || exit 1

# Usuário não-root
RUN useradd -r -u 1001 quarkus
USER quarkus

# Inicialização da aplicação
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar quarkus-run.jar"]