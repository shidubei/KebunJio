import React, { useState } from 'react';
import Appbar from '../../../components/Appbar'
import MenuSidebar from '../components/menu-sidebar'
import '../styling/forum-page.css'
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';

function ForumNewPost() {

  const [formData, setFormData] = useState({
    category: '',
    title: '',
    question: '',
    image: null,
  });

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleFileChange = (e) => {
    setFormData({ ...formData, image: e.target.files[0] });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    //if all are filled
    if(formData.category!==''&&formData.title!==''&&formData.question!==''){
      console.log('Form submitted:', formData);
      alert('Post created successfully!');
    }
  };

  const resetPost = (e) => {
    setFormData({ category: '', title: '', question: '', image: null })
  }

  return (
    <div>
      <Appbar/>
      <div className="page-container">
        <div className="menu-sidebar">
            <MenuSidebar/>
        </div>
        <div className="main-content">
          <p>New post</p>
          <Form onSubmit={handleSubmit}>
            <Form.Group controlId="category">
              <Form.Label>Select category</Form.Label>
              <Form.Select
                name="category"
                value={formData.category}
                onChange={handleInputChange}
                required
              >
                <option value="">Select category</option>
                <option value="herb">Herb</option>
                <option value="leafy-vegetable">Leafy vegetables</option>
                <option value="fruit-vegetable">Fruit vegetables</option>
                <option value="fruit">Fruit</option>
                <option value="tuber-roots">Tuber and Roots</option>
                <option value="vines-climbers">Vines and Climbers</option>
                <option value="others">Others</option>
              </Form.Select>
            </Form.Group>

            <Form.Group controlId="title">
              <Form.Label>Title</Form.Label>
              <Form.Control
                as="textarea"
                placeholder="Insert title here"
                name="title"
                value={formData.title}
                onChange={handleInputChange}
                required
              />
            </Form.Group>

            <Form.Group controlId="question">
              <Form.Label>Question</Form.Label>
              <Form.Control
                as="textarea"
                placeholder="Type your question here"
                name="question"
                value={formData.question}
                onChange={handleInputChange}
                required
              />

            </Form.Group>

            <Form.Group controlId="image">
              <Form.Label>Upload image</Form.Label>
              <Form.Control
                type="file"
                name="image"
                onChange={handleFileChange}
              />
            </Form.Group>

            <div>
              <Button variant="secondary" type="reset" onClick={resetPost}>
                Cancel
              </Button>
              <Button variant="primary" type="submit">
                Post
              </Button>
            </div>
          </Form>
        </div>
      </div>
    </div>
  );
}

export default ForumNewPost;