import React, {useState} from 'react';
import Appbar from '../../../components/Appbar'
import MenuSidebar from '../components/menu-sidebar'
import '../styling/forum-page.css'
import PostSneakPeak from '../components/post-sneak-peek';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import { useNavigate } from "react-router-dom";

function ForumSearchPage() {
 let navigate = useNavigate();
 
   const routeChange = (post) =>{ 
     navigate(`/forum/post/?id=${post.id}`, { state: { post } });
   }
 
   const search_results = [{
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

  const [searchInput, setSearchInput] = useState('');

  const handleSearchInputChange = (event) => {
      setSearchInput(event.target.value);
  };

  const handleSearchSubmit = (event) => {
    console.log(searchInput)
  }

  return (
    <div>
      <Appbar/>
      <div className="page-container">
        <div className="menu-sidebar">
            <MenuSidebar/>
        </div>
        <div className="main-content">
          <div>
            <Form className="d-flex">
              <Form.Control
                type="search"
                placeholder="Search"
                className="me-2"
                aria-label="Search"
                onChange={handleSearchInputChange}
              />
              <Button variant="primary" onClick={handleSearchSubmit}>Search</Button>
            </Form>
          </div>
          <div>
            <p>Search result:</p>
            {search_results.length!==0?(search_results.map((post,index)=>(
                <PostSneakPeak key={index} post={post} onClick={() => routeChange(post)}/>
            ))):(<p>No result</p>)}
          </div>
        </div>
      </div>
    </div>
  );
}

export default ForumSearchPage;