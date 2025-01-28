import React, {useState} from "react";
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from "react-bootstrap/Col";
import Button from 'react-bootstrap/Button';

const ReplyInsight = ({cur_like, cur_dislike}) => {
    const [like, setLike] = useState(cur_like);
    const [dislike, setDislike] = useState(cur_dislike);

    const handleLike = () => {
        //TODO: update to API
        setLike(like + 1);
    };

    const handleDislike = () => {
        //TODO: update to API
        setDislike(dislike + 1);
    };

    return(
        <Container>
            <Row>
                <Col>
                    <Button onClick={handleLike}>Like</Button><span>{like}</span>
                </Col>
                <Col>
                    <Button onClick={handleDislike}>Dislike</Button><span>{dislike}</span>
                </Col>
            </Row>
        </Container>
    )
}

export default ReplyInsight