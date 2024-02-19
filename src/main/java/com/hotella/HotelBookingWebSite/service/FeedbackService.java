package com.hotella.HotelBookingWebSite.service;

import com.hotella.HotelBookingWebSite.entity.Feedback;
import com.hotella.HotelBookingWebSite.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    @Autowired
    FeedbackRepository feedbackRepository;

    public Feedback saveFeedback(Feedback feedback) {

        return feedbackRepository.save(feedback);
    }
}
