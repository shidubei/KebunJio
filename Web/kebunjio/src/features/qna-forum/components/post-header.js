import React from "react";
import Image from 'react-bootstrap/Image';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from "react-bootstrap/Col";


const PostHeader = ({username, time}) =>{
    return(
        <Container>
            <Row>
                <Col>
                    <Image src="../../../media/placeholder.jpg" roundedCircle ></Image>
                </Col>
                <Col>
                    <Row>{username}</Row>
                    <Row>{time}</Row>
                </Col>
                <Col>
                    Menu
                </Col>
            </Row>
        </Container>
    )
}

export default PostHeader