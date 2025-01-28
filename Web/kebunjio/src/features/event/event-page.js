import React, { useState, useEffect } from 'react';
import { Routes, Route } from 'react-router-dom';
import EventCard from './components/EventCard';
import EventDetail from './components/EventDetail';
import GoogleAuthCallback from './components/googleCalendar/GoogleAuthCallback';
import { getAllEvents } from './services/eventService';

const EventList = () => {
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
        return (
            <div className="flex items-center justify-center min-h-screen">
                <div className="animate-spin rounded-full h-12 w-12 border-b-2 border-blue-500" />
            </div>
        );
    }

    return (
        <div className="container mx-auto px-4 py-8">
            <h1 className="text-3xl font-bold mb-8">Upcoming Events</h1>
            <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
                {events.map((event) => (
                    <EventCard key={event.eventId} event={event} />
                ))}
            </div>
        </div>
    );
};

const EventPage = () => {
    return (
        <Routes>
            {/* Event list route */}
            <Route path="/" element={<EventList />} />

            {/* Event detail route */}
            <Route path="/:id" element={<EventDetail />} />

            {/* Google Calendar callback route */}
            <Route path="/oauth2/callback" element={<GoogleAuthCallback />} />
        </Routes>
    );
};

export default EventPage;