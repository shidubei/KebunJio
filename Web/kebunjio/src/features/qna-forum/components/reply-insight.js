import React from "react";
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from "react-bootstrap/Col";

const ReplyInsight = ({like, dislike}) => {
    return(
        <Container>
            <Row>
                <Col>Like: {like}</Col>
                <Col>Dislike: {dislike}</Col>
            </Row>
        </Container>
    )
}

export default ReplyInsight