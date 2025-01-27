import React from "react";
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import PostHeader from "./post-header";
import PostInsight from "./post-insight";

//need to trim down the post length
function trimContent(content) {
    if(content.length>100){
        var trimmed_content = content.slice(0,100) + " See more..."
        return trimmed_content
    }
    else{
        return content
    }
}

const PostSneakPeak = ({post, onClick}) => {
    return(
        <div onClick={onClick}>
            <Container>
                <Row><PostHeader username={post.username} time={post.time}/></Row>
                <Row>
                    <b>{post.title}</b>
                    <p>{post.tag}</p>
                    <p>{trimContent(post.content)}</p>
                </Row>
                <Row><PostInsight upvote={post.upvote} comment={post.comment}/></Row>
            </Container>
        </div>
    )
}

export default PostSneakPeak;