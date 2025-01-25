import React from "react";

import FullPost from '../components/full-post'
import Reply from "../components/reply";
import Form from 'react-bootstrap/Form';
import { Button } from "react-bootstrap";

function Post(){
return(
    <div>
        <div>
            <FullPost/>
        </div>
        <div>
            <Form>
                <Form.Group controlId="exampleForm.ControlInput1">
                    <Form.Control type="textarea" placeholder="Write your reply here" />
                </Form.Group>
                <Button type="submit">Cancel</Button>
                <Button type="submit">Reply</Button>
            </Form>
        </div>
        <div>
            <Reply/>
        </div>
    </div>

)}

export default Post