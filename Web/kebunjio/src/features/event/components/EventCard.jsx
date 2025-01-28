import React from 'react';
import { useNavigate } from 'react-router-dom';

const EventCard = ({ event }) => {
    const navigate = useNavigate();

    const handleClick = () => {
        navigate(`/events/${event.eventId}`);
    };

    return (
        <div className="event-card" onClick={handleClick}>
            {event.Picture && (
                <div className="event-image">
                    <img src={event.Picture} alt={event.name} />
                </div>
            )}
            <div className="event-content">
                <h3>{event.name}</h3>
                <p className="event-date">
                    {new Date(event.StartDateTime).toLocaleDateString()}
                </p>
                <p className="event-location">{event.location}</p>
                <p className="event-description">{event.description}</p>
            </div>
        </div>
    );
};

export default EventCard;