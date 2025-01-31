import React, { useState } from "react";
import Image from 'react-bootstrap/Image';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from "react-bootstrap/Col";
import Dropdown from 'react-bootstrap/Dropdown';
import { useNavigate } from "react-router-dom";

import '../styling/forum-page.css'
import placeholderImage from '../../../media/placeholder.jpg';

const ReplyHeader = ({username, time, onEdit, onDelete}) =>{
    return(
        <Container className="post-header">
            <Row className="align-items-center">
                <Col xs="auto">
                    <Image
                        src={placeholderImage}
                        roundedCircle
                        className="reply-header-avatar"
                    />
                </Col>
                <Col>
                    <div className="post-header-info">
                        <div className="reply-header-username">{username}</div>
                        <div className="reply-header-time">{time}</div>
                    </div>
                </Col>
                <Col xs="auto">
                {
                    username==="Kelly"?(<Dropdown>
                        <Dropdown.Toggle className="three-dot">
                        </Dropdown.Toggle>
                            <Dropdown.Menu>
                                <Dropdown.Item onClick={onEdit}>Edit Reply</Dropdown.Item>
                                <Dropdown.Item onClick={onDelete}>Delete Reply</Dropdown.Item>
                            </Dropdown.Menu>
                        </Dropdown>):(<div></div>)
                }
                </Col>
            </Row>
        </Container>
    )
}

export default ReplyHeader