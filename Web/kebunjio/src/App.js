import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import DashboardPage from './features/dashboard/index';
import { EventPage, EventDetail } from './features/event';
import ForumTopPage from './features/qna-forum/pages/forum-top-page';
import ForumMyPage from './features/qna-forum/pages/forum-my-post';
import ForumNewPost from './features/qna-forum/pages/forum-new-post';
import ForumSearchPage from './features/qna-forum/pages/forum-search-page';
import UserProfilePage from './features/user-profile/user-profile-page';
import ViewPost from './features/qna-forum/pages/forum-view-post'
import LoginPage from './features/login-signup/login';
import SignUpPage from './features/login-signup/signup';
import ForumEditPost from './features/qna-forum/pages/forum-edit-post';
import UserProfileEditPage from "./features/user-profile/user-profile-edit-page";

function App() {
  return (
      <BrowserRouter>
        <Routes>
          <Route path="/login" element={<LoginPage />} />
          <Route path="/signup" element={<SignUpPage />} />
          <Route path="/dashboard" element={<DashboardPage />} />
          <Route path="/events" element={<EventPage />} />
          <Route path="/events/:id" element={<EventDetail />} />
          <Route path="/event" element={<EventPage />} />
          <Route path="/forum" element={<ForumTopPage/>} />
          <Route path="/forum/search" element={<ForumSearchPage/>} />
          <Route path="/forum/new" element={<ForumNewPost/>} /> 
          <Route path="/forum/my" element={<ForumMyPage/>} /> 
          <Route path="/forum/post" element={<ViewPost/>} /> 
          <Route path="/user-profile" element={<UserProfilePage/>} />
          <Route path="/user-profile/update" element={<UserProfileEditPage/>} />
          <Route path="/forum/:id/edit" element={<ForumEditPost />} />
        </Routes>
      </BrowserRouter>
);
}

export default App;