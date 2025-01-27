import React from 'react';
import Appbar from '../../../components/Appbar'
import MenuSidebar from '../components/menu-sidebar'
import PostSneakPeak from '../components/post-sneak-peek';
import '../styling/forum-page.css'

const posts = [{
  username: "Kelly",
  time: new Date("2025-01-27").toDateString(),
  title: "What is wrong with my cabbage",
  content: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ac nulla dictum, sodales tellus et, placerat dui. Etiam placerat ipsum quam, eget tincidunt augue iaculis id. Vivamus blandit dictum hendrerit. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Proin a eleifend nisi. Mauris pulvinar mauris sed ligula convallis, ac viverra arcu ultricies. Aliquam purus odio, sodales quis molestie vitae, ultrices eu purus. Nulla nec nisl elit. Ut lectus magna, volutpat non erat sed, pharetra venenatis metus. Phasellus ullamcorper tincidunt neque vel ultricies. Cras suscipit dapibus mauris, ut accumsan nunc tristique a. In convallis diam a diam facilisis, eu vehicula lacus convallis. Vestibulum tempor ac erat id egestas. Donec neque lectus, consequat vitae velit in, semper facilisis leo. Sed at est eget velit tincidunt tempor. Maecenas aliquam, tellus eget convallis sollicitudin, nisl ex fermentum velit, quis finibus justo magna vel urna. Nunc lacinia consequat risus, nec tincidunt sapien. Donec eget aliquet diam. Sed vitae tellus ex. Praesent vehicula odio sed augue imperdiet mattis. Curabitur id mauris eget nulla tempus lobortis at non ipsum. Suspendisse bibendum nulla justo, a dignissim sapien pulvinar id. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.",
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


function ForumTopPage() {
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