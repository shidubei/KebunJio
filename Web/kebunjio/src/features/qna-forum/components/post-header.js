import React from "react";
import Image from 'react-bootstrap/Image';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from "react-bootstrap/Col";


function PostHeader(){
    return(
        <Container>
            <Row>
                <Col>
                    <Image src="../../../media/placeholder.jpg" roundedCircle ></Image>
                </Col>
                <Col>
                    <Row>@Username</Row>
                    <Row>12 November 2020 19:35</Row>
                </Col>
                <Col>
                    Menu
                </Col>
            </Row>
        </Container>
    )
}

export default PostHeader