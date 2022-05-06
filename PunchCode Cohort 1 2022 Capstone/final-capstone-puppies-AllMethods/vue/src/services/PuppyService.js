import axios from 'axios';



export default {
  list() {
    return axios.get('/api/allPuppies');
  },

  get(id) {
    return axios.get(`/api/puppy/${id}`);
  },

  // add a puppy to endpoint /newPuppy

  // update a puppy to endpoint /editPuppy

  // delete a puppy to endpoint /removePuppy/id
  create(puppy) {
    return axios.post('/api/savePuppy', puppy);
  },

  update(puppy) {
    return axios.put(`/api/editPuppy/${puppy.id}`, puppy);
  },

  delete(id) {
    return axios.delete(`/api/removePuppy/${id}`);
  }
}
