import React from "react";
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import PostHeader from "./post-header";
import PostInsight from "./post-insight";
import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';


function FullPost(){
    return(
        <div>
            <div>
                <Container>
                    <Row><PostHeader/></Row>
                    <Row>
                        <b>Title</b>
                        <p>Tag</p>
                        <p>Content</p>
                    </Row>
                    <Row>
                        <Col>
                            <PostInsight/>
                        </Col>
                        <Col>
                            <Button>Vote</Button>
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