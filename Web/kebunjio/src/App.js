import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import DashboardPage from './features/dashboard/dashboard-page';
import { EventPage, EventDetail } from './features/event';
import ForumPage from './features/qna-forum/forum-page';
import UserProfilePage from './features/user-profile/user-profile-page';
import LoginPage from './features/login-signup/login';
import SignUpPage from './features/login-signup/signup';

function App() {
  return (
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<LoginPage />} />
          <Route path="/signup" element={<SignUpPage />} />
          <Route path="/dashboard" element={<DashboardPage />} />
          <Route path="/events" element={<EventPage />} />
          <Route path="/events/:id" element={<EventDetail />} />
          <Route path="/forum" element={<ForumPage/>} />
          <Route path="/user-profile" element={<UserProfilePage/>} />
        </Routes>
      </BrowserRouter>
  );
}

export default App;