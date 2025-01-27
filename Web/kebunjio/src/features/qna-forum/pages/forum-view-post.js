import React, {useState} from "react";

import FullPost from '../components/full-post'
import Reply from "../components/reply";
import Form from 'react-bootstrap/Form';
import { Button } from "react-bootstrap";
import { useLocation } from "react-router-dom";

import Appbar from '../../../components/Appbar'
import MenuSidebar from '../components/menu-sidebar'
import '../styling/forum-page.css'

function Post(){
    const location = useLocation();
    const { post } = location.state || {}; 

    const replies = [{
        username: "Yasmine",
        time: new Date("2025-01-30").toDateString(),
        content: "OK, cool",
        like: 12,
        dislike: 3
    },
    {
        username: "Yasmine",
        time: new Date("2025-01-30").toDateString(),
        content: "OK, cool",
        like: 12,
        dislike: 3
    }]

    const [replyInput, setReplyInput] = useState('')

    const handleReplyInputChange = (event) => {
        setReplyInput(event.target.value)
    }

    if (!post) {
        return <p>No post data available. Please navigate through the forum page.</p>;
    }

    return(
        <div>
            <Appbar/>
            <div className="page-container">
                <div className="menu-sidebar">
                    <MenuSidebar/>
                </div>
                <div className="main-content">
                <div>
                    <FullPost post={post}/>
                </div>
                <div>
                    <Form>
                        <Form.Group controlId="exampleForm.ControlInput1">
                            <Form.Control type="textarea" placeholder="Write your reply here" onChange={handleReplyInputChange}/>
                        </Form.Group>
                        <Button type="submit">Cancel</Button>
                        <Button type="submit">Reply</Button>
                    </Form>
                </div>
                <div>
                {replies.length !== 0 ? (
                    replies.map((reply, index) => (
                        <Reply key={index} reply={reply} />
                    ))
                ) : (
                    <p>No replies yet</p>
                )}
                </div>

                </div>
            </div>
        </div>

    )}

export default Post