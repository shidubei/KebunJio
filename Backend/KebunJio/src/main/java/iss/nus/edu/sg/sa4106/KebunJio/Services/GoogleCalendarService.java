package iss.nus.edu.sg.sa4106.KebunJio.Services;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.calendar.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GoogleCalendarService {

    @Autowired
    private GoogleAuthorizationCodeFlow flow;

    @Value("${google.redirect.uri}")
    private String redirectUri;

    public String getAuthorizationUrl() {
        return flow.newAuthorizationUrl()
                .setRedirectUri(redirectUri)
                .build();
    }

    public boolean addEventToCalendar(String code, Event event) throws Exception {
        GoogleTokenResponse tokenResponse = flow.newTokenRequest(code)
                .setRedirectUri(redirectUri)
                .execute();

        Calendar service = new Calendar.Builder(
                new NetHttpTransport(),
                JacksonFactory.getDefaultInstance(),
                tokenResponse.createCredential()
        ).setApplicationName("KebunJio")
                .build();

        com.google.api.services.calendar.model.Event googleEvent = event.toGoogleCalendarEvent();
        com.google.api.services.calendar.model.Event createdEvent =
                service.events().insert("primary", googleEvent).execute();

        return createdEvent != null;
    }
}