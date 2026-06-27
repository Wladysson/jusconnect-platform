package com.jusconnect.scheduling.domain.model;

import com.jusconnect.scheduling.domain.enums.MeetingPlatform;

public class MeetingInfo {

    private MeetingPlatform platform;

    private String meetingLink;

    private String meetingCode;

    private String meetingPassword;

    private String hostEmail;

    public MeetingInfo() {
    }

    public MeetingPlatform getPlatform() {
        return platform;
    }

    public void setPlatform(
            MeetingPlatform platform
    ) {
        this.platform = platform;
    }

    public String getMeetingLink() {
        return meetingLink;
    }

    public void setMeetingLink(
            String meetingLink
    ) {
        this.meetingLink = meetingLink;
    }

    public String getMeetingCode() {
        return meetingCode;
    }

    public void setMeetingCode(
            String meetingCode
    ) {
        this.meetingCode = meetingCode;
    }

    public String getMeetingPassword() {
        return meetingPassword;
    }

    public void setMeetingPassword(
            String meetingPassword
    ) {
        this.meetingPassword = meetingPassword;
    }

    public String getHostEmail() {
        return hostEmail;
    }

    public void setHostEmail(
            String hostEmail
    ) {
        this.hostEmail = hostEmail;
    }

    public boolean isOnline() {

        return platform != null
                && platform != MeetingPlatform.PRESENTIAL;
    }

    public boolean isPresential() {

        return platform == MeetingPlatform.PRESENTIAL;
    }

    public boolean hasMeetingLink() {

        return meetingLink != null
                && !meetingLink.isBlank();
    }

    public boolean hasPassword() {

        return meetingPassword != null
                && !meetingPassword.isBlank();
    }
}