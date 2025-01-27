import React from 'react';
import Appbar from '../../../components/Appbar'
import MenuSidebar from '../components/menu-sidebar'
import PostSneakPeak from '../components/post-sneak-peek';
import '../styling/forum-page.css'

function ForumTopPage() {
  const posts = [{
    username: "Kelly",
    time: new Date("2025-01-27").toDateString(),
    title: "What is wrong with my cabbage",
    tag: "tag1",
    content: "Can anyone tell me what's wrong with my cabbage?",
    upvote: 50,
    comment: 12
  },
  {
    username: "Kelly",
    time: new Date("2025-01-27").toDateString(),
    title: "What is wrong with my cabbage",
    content: "Can anyone tell me what's wrong with my cabbage?",
    tag: "tag1",
    upvote: 50,
    comment: 12
  },
  {
    username: "Kelly",
    time: new Date("2025-01-27").toDateString(),
    title: "What is wrong with my cabbage",
    content: "Can anyone tell me what's wrong with my cabbage?",
    tag: "tag1",
    upvote: 50,
    comment: 12
  }]
  
  return (
    <div>
      <Appbar/>
      <div className="page-container">
        <div className="menu-sidebar">
            <MenuSidebar/>
        </div>
        <div className="main-content">
          {posts.map((post,index)=>(
            <PostSneakPeak key={index} post={post}/>
          ))}
        </div>
      </div>
    </div>
  );
}

export default ForumTopPage;