import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import { getEventById } from '../services/eventService';
import AddToGoogleCalendar from './googleCalendar/AddToGoogleCalendar';

const EventDetail = () => {
    const { id } = useParams();
    const [event, setEvent] = useState(null);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        fetchEventDetails();
    }, [id]);

    const fetchEventDetails = async () => {
        try {
            const response = await getEventById(id);
            setEvent(response.data);
        } catch (error) {
            console.error('Error fetching event details:', error);
        } finally {
            setLoading(false);
        }
    };

    if (loading) return <div>Loading...</div>;
    if (!event) return <div>Event not found</div>;

    const calendarEvent = {
        id: event.id,
        eventId: event.eventId,
        title: event.name,
        description: event.description,
        location: event.location,
        startTime: event.startDateTime,
        endTime: event.endDateTime,
        picture: event.picture
    };

    return (
        <div className="event-detail max-w-4xl mx-auto p-6">
            <div className="event-header mb-6">
                <h1 className="text-3xl font-bold mb-2">{event.name}</h1>
                <div className="mt-4">
                    <AddToGoogleCalendar event={calendarEvent} />
                </div>
            </div>

            {event.picture && (
                <div className="event-image mb-6">
                    <img
                        src={event.picture}
                        alt={event.name}
                        className="w-full rounded-lg shadow-md"
                    />
                </div>
            )}

            <div className="event-info space-y-6">
                <div className="info-group bg-white p-4 rounded-lg shadow">
                    <h2 className="text-xl font-semibold mb-2">Date & Time</h2>
                    <p className="text-gray-700">
                        Start: {new Date(event.startDateTime).toLocaleString()}
                    </p>
                    <p className="text-gray-700">
                        End: {new Date(event.endDateTime).toLocaleString()}
                    </p>
                </div>

                <div className="info-group bg-white p-4 rounded-lg shadow">
                    <h2 className="text-xl font-semibold mb-2">Location</h2>
                    <p className="text-gray-700">{event.location}</p>
                </div>

                <div className="info-group bg-white p-4 rounded-lg shadow">
                    <h2 className="text-xl font-semibold mb-2">Description</h2>
                    <p className="text-gray-700 whitespace-pre-wrap">{event.description}</p>
                </div>
            </div>
        </div>
    );
};

export default EventDetail;