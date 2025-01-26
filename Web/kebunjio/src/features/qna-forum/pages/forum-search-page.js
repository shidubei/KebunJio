import React from 'react';
import Appbar from '../../../components/Appbar'
import MenuSidebar from '../components/menu-sidebar'
import '../styling/forum-page.css'
import PostSneakPeak from '../components/post-sneak-peek';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';

function ForumSearchPage() {
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
              />
              <Button variant="primary">Search</Button>
            </Form>
          </div>
          <div>
            <p>Search result:</p>
            <PostSneakPeak/>
          </div>
        </div>
      </div>
    </div>
  );
}

export default ForumSearchPage;