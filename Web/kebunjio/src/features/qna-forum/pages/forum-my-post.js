import React from 'react';
import Appbar from '../../../components/Appbar'
import MenuSidebar from '../components/menu-sidebar'
import '../styling/forum-page.css'
import PostSneakPeak from '../components/post-sneak-peek';
import { useNavigate } from "react-router-dom";

function ForumMyPage() {
  let navigate = useNavigate();

  const routeChange = (post) =>{ 
    navigate(`/forum/post/?id=${post.id}`, { state: { post } });
  }

  const posts = [{
    id: 1,
    username: "Kelly",
    time: new Date("2025-01-27").toDateString(),
    title: "What is wrong with my cabbage",
    tag: "tag1",
    content: "Can anyone tell me what's wrong with my cabbage?",
    upvote: 50,
    comment: 12
  },
  {
    id: 2,
    username: "Yasmine",
    time: new Date("2025-01-28").toDateString(),
    title: "What is wrong with my tomato",
    content: "Can anyone tell me what's wrong with my tomato?",
    tag: "tag2",
    upvote: 40,
    comment: 13
  },
  {
    id: 3,
    username: "KY",
    time: new Date("2025-01-29").toDateString(),
    title: "What is wrong with my spinach",
    content: "Can anyone tell me what's wrong with my spinach?",
    tag: "tag3",
    upvote: 30,
    comment: 14
  }]

  return (
    <div>
      <Appbar/>
      <div className="page-container">
        <div className="menu-sidebar">
            <MenuSidebar/>
        </div>
        <div className="main-content">
        <p>My post:</p>
            {posts.length!==0?(posts.map((post,index)=>(
                <PostSneakPeak key={index} post={post} onClick={() => routeChange(post)}/>
            ))):(<p>No result</p>)}
        </div>
      </div>
    </div>
  );
}

export default ForumMyPage;