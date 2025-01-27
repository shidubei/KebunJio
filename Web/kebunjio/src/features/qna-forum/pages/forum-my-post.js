import React from 'react';
import Appbar from '../../../components/Appbar'
import MenuSidebar from '../components/menu-sidebar'
import '../styling/forum-page.css'
import PostSneakPeak from '../components/post-sneak-peek';

const posts = [{
  username: "Kelly",
  time: new Date("2025-01-27").toDateString(),
  title: "What is wrong with my cabbage",
  content: "Can anyone tell me what's wrong with my cabbage?",
  upvote: 50,
  comment: 12
},
{
  username: "Kelly",
  time: new Date("2025-01-27").toDateString(),
  title: "What is wrong with my cabbage",
  content: "Can anyone tell me what's wrong with my cabbage?",
  upvote: 50,
  comment: 12
},
{
  username: "Kelly",
  time: new Date("2025-01-27").toDateString(),
  title: "What is wrong with my cabbage",
  content: "Can anyone tell me what's wrong with my cabbage?",
  upvote: 50,
  comment: 12
}]

function ForumMyPage() {

  return (
    <div>
      <Appbar/>
      <div className="page-container">
        <div className="menu-sidebar">
            <MenuSidebar/>
        </div>
        <div className="main-content">
        <p>Search result:</p>
            {posts.length!=0?(posts.map((post,index)=>(
              <PostSneakPeak key={index} post={post}/>
            ))):(<p>No result</p>)}
        </div>
      </div>
    </div>
  );
}

export default ForumMyPage;