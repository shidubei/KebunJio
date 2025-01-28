const API_BASE_URL = process.env.REACT_APP_API_BASE_URL || 'http://localhost:8080/api';

class GoogleCalendarService {
    async getAuthUrl() {
        try {
            const response = await fetch(`${API_BASE_URL}/google/calendar/auth-url`, {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                },
                credentials: 'include',
            });

            if (!response.ok) {
                throw new Error('Failed to get authorization URL');
            }

            const data = await response.json();
            return data.authUrl;
        } catch (error) {
            throw error;
        }
    }

    async handleAuthCallback(code, eventData) {
        try {
            const response = await fetch(`${API_BASE_URL}/google/calendar/callback`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                credentials: 'include',
                body: JSON.stringify({
                    code,
                    eventData: {
                        id: eventData.id,
                        eventId: eventData.eventId,
                        name: eventData.title,
                        description: eventData.description,
                        location: eventData.location,
                        startDateTime: new Date(eventData.startTime).toISOString(),
                        endDateTime: new Date(eventData.endTime).toISOString(),
                        picture: eventData.picture
                    }
                }),
            });

            if (!response.ok) {
                const errorData = await response.json();
                throw new Error(errorData.message || 'Failed to add event to calendar');
            }

            return response.json();
        } catch (error) {
            throw error;
        }
    }
}

export const googleCalendarService = new GoogleCalendarService();