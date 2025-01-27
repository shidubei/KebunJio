import React, { useState, useEffect } from 'react';
import EventCard from './components/EventCard';
import { getAllEvents } from './services/eventService';

function EventPage() {
    const [events, setEvents] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        fetchEvents();
    }, []);

    const fetchEvents = async () => {
        try {
            const response = await getAllEvents();
            setEvents(response.data);
        } catch (error) {
            console.error('Error fetching events:', error);
        } finally {
            setLoading(false);
        }
    };

    if (loading) {
        return <div>Loading...</div>;
    }

    return (
        <div>
            <h1>Upcoming Events</h1>
            <div className="event-grid">
                {events.map((event) => (
                    <EventCard key={event.eventId} event={event} />
                ))}
            </div>
        </div>
    );
}

export default EventPage;