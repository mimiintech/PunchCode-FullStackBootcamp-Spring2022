import axios from 'axios';


export default {
    list() {
        return axios.get('/api/allForum');
    },

// get(id) {
//     return axios.get('/api/forum/${id}');
// },

// delete(id) {
//     return axios.delete('/api/deleteQuestion/${id}');
// },

// create(forum) {
//     return axios.post('/api/addQuestion');
// },

// update(forum) {
//     return axios.put('api/updateQuestion/${id}');
// },

}