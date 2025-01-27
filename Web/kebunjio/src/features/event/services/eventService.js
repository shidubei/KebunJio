import axios from 'axios';

const BASE_URL = 'http://localhost:8080/api/events';

export const getAllEvents = () => {
    return axios.get(BASE_URL);
};

export const getEventById = (id) => {
    return axios.get(`${BASE_URL}/${id}`);
};

export const createEvent = (eventData) => {
    return axios.post(BASE_URL, eventData);
};

export const updateEvent = (id, eventData) => {
    return axios.put(`${BASE_URL}/${id}`, eventData);
};

export const deleteEvent = (id) => {
    return axios.delete(`${BASE_URL}/${id}`);
};