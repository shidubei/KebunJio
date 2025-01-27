import React from "react";
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import PostHeader from "./post-header";
import PostInsight from "./post-insight";
import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';

const FullPost = ({post}) => {
    return(
        <div>
            <div>
                <Container>
                    <Row><PostHeader/></Row>
                    <Row>
                        <b>{post.title}</b>
                        <p>{post.tag}</p>
                        <p>{post.content}</p>
                    </Row>
                    <Row>
                        <Col>
                            <PostInsight/>
                        </Col>
                        <Col>
                            <Button>Upvote</Button>
                        </Col>
                    </Row>

                </Container>
            </div>
            <div>

            </div>
        </div>
    )
}

export default FullPost;