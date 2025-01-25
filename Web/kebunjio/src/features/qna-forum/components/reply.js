import React from "react";
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import PostHeader from "./post-header";
import ReplyInsight from "./reply-insight";

function Reply(){
    return(
        <div>
            <Container>
                <Row><PostHeader/></Row>
                <Row>
                    <p>Content</p>
                </Row>
                <Row><ReplyInsight/></Row>
            </Container>
        </div>
    )
}

export default Reply;