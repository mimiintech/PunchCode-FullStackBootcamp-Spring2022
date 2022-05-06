import axios from 'axios';


export default {
    list() {
        return axios.get('/api/allFeedback');
    },

// get(id) {
//     return axios.get('/api/feedback/${id}');
// },

// delete(id) {
//     return axios.delete('/api/deleteAnswer/${id}');
// },

// create(forum) {
//     return axios.post('/api/addAnswer');
// },

// update(forum) {
//     return axios.put('api/updateAnswer/${id}');
// },

}