package com.techelevator.dao;

import com.techelevator.model.exceptions.AnnouncementNotFoundException;
import com.techelevator.model.school.Announcement;
import com.techelevator.model.school.NewAnnouncement;

public interface AdminDao {

    //get most recent announcement
    Announcement getLatestAnnouncement();

    //get announcement by id
    Announcement getAnnouncementById(int announcementId) throws AnnouncementNotFoundException;

    //create an announcement
    Announcement createAnnouncement(NewAnnouncement newAnnouncement, int adminId);



}
