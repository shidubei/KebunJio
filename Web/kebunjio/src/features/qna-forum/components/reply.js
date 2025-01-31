import React, {useState} from "react";
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import ReplyHeader from "./reply-header";
import ReplyInsight from "./reply-insight";
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';

const Reply = ({userReply}) => {

    const [reply, setReply] = useState(userReply)

    const [isEditing, setIsEditing] = useState(false)
    
    const onClickEdit = () =>{
        setIsEditing(true)
    }

    const onClickDelete = () => {
        alert("Delete reply")
    }

    const onSubmitEdit = (e) => {
        setReply({ ...reply, content: e.target.value });
    }

    return(
        <div>
            <Container>
                <Row><ReplyHeader username={reply.username} time={reply.time} onDelete={onClickDelete} onEdit={onClickEdit}/></Row>
                <Row>
                    {isEditing?(
                        <Form>
                            <Form.Control
                                as="textarea"
                                value={reply.content}/>
                            <Button onClick={onSubmitEdit}>Edit</Button>
                        </Form>
                    ):
                    (
                        <p style={{fontSize:"0.9rem"}}>{reply.content}</p>

                    )}                
                    </Row>
                <Row><ReplyInsight cur_like={reply.like} cur_dislike={reply.dislike} has_liked={reply.hasLiked} has_disliked={reply.hasDisliked}/></Row>
            </Container>
        </div>
    )
}

export default Reply;