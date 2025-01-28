import React from "react";
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import PostHeader from "./post-header";
import ReplyInsight from "./reply-insight";

const Reply = ({reply}) => {
    return(
        <div>
            <Container>
                <Row><PostHeader username={reply.username} time={reply.time}/></Row>
                <Row>
                    <p>{reply.content}</p>
                </Row>
                <Row><ReplyInsight cur_like={reply.like} cur_dislike={reply.dislike}/></Row>
            </Container>
        </div>
    )
}

export default Reply;