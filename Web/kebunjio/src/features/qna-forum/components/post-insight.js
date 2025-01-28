import React from "react";
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from "react-bootstrap/Col";

const PostInsight = ({upvote, comment}) => {
    return(
        <Container className="post-insight">
            <Row xs="auto">
                <Col>Upvote: {upvote}</Col>
                <Col>Comment: {comment}</Col>
            </Row>
        </Container>
    )
}

export default PostInsight