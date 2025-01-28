import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import { getEventById } from '../services/eventService';

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

    return (
        <div className="event-detail">
            <div className="event-header">
                <h1>{event.name}</h1>
            </div>

            {event.Picture && (
                <div className="event-image">
                    <img src={event.Picture} alt={event.name} />
                </div>
            )}

            <div className="event-info">
                <div className="info-group">
                    <h2>Date & Time</h2>
                    <p>Start: {new Date(event.StartDateTime).toLocaleString()}</p>
                    <p>End: {new Date(event.EndDateTime).toLocaleString()}</p>
                </div>

                <div className="info-group">
                    <h2>Location</h2>
                    <p>{event.location}</p>
                </div>

                <div className="info-group">
                    <h2>Description</h2>
                    <p>{event.description}</p>
                </div>
            </div>
        </div>
    );
};

export default EventDetail;