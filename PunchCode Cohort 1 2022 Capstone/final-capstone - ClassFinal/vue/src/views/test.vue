<template>
    <body>
        <div id="forum">

            <div id="forum-head">
                <div id="upper-question">
                    <h2>Questions</h2>
                    <p>Do you have questions for Stephany? Ask them here!</p>
                    <input id="question-input" placeholder="Ask your question...">
                    <button >Submit</button>
                </div>
            </div>

            <div id="forum-body">
                <div id="forum-body-left">
                    <h2>Answered questions</h2>
                    <div class="row">
                        <div class="card" v-for="forum in forums" :key="forum.id">
                            <div v-for="feedback in feedbacks" :key="feedback.id">
                                <h5 style="text-align: left">March. 18th, 2022</h5>
                                <h5 style="text-align: right">3 hours ago</h5>
                                <h3>{{forum.question}}</h3>
                                <p>{{feedback.answer}}.</p>
                            </div>
                        </div>
                    </div>   
                </div>

                <div id="forum-body-middle">
                    <h2>Pending questions</h2>
                    <div class="row">
                        <div class="card">
                            <h5 style="text-align: left">Jan. 14th, 2022</h5>
                               <h5 style="text-align:right">Pending</h5>
                            <h3>"What are the basics of Security?"</h3>
                            <input id="pending-input" placeholder="Pending answer...">
                            <button>Submit</button>
                        </div>
                    </div>

                    <div class="row">
                        <div class="card">
                            <h5 style="text-align: left">Jan. 12th, 2022</h5>
                               <h5 style="text-align:right">Pending</h5>
                            <h3>"What is Cryptography?"</h3>
                            <input id="pending-input" placeholder="Pending answer...">
                            <button>Submit</button>
                        </div>
                    </div>

                </div>
                
                <div id="forum-body-right">
                      <h2 >Empowering Women in Tech</h2>
                    <div id="steph-bio">
                            <h3>About the Author</h3>
                            <img src="./photo.jpg" alt="" width="400">
                    </div>
                    <div id="paragraph">
                            <p style="text-align:center; font-family: georgia">Women in Tech will be the New Norm.</p>
                    </div>
                </div>
            </div>
        </div>
    </body>


</template>

<script>

// Create Forum Question

import Forum from "@/services/Forum";
import Feedback from "@/services/Feedback";



export default {
    data() {
    return { forums: [] }, { feedbacks: [] };
    },

    created(){
        Forum
        .list()
        .then((forumData) => {
            this.forums = forumData.data;
        })
        .catch((err) => {
        console.error(err + " uh oh missing forums!");
      });
    },
    create(){
        Feedback
        .list()
        .then((feedbackData) => {
            this.feedbacks = feedbackData.data;
        })
        .catch((err) => {
        console.error(err + " uh oh missing feedback!");
      });
    },


</script>



<style scoped>


h3 {
    font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
}

h2 {
    font-family:Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
}

p {
    font-family: 'Times New Roman', Times, serif;
    font-size: large;
     border: 3px double #778899;
}



#question-input {
    width: 50%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  border: 4px double #778899;
  font-size: 15px;
  font-family: 'Times New Roman', Times, serif;
}

button {
          display: inline-block;
        background-color: #FFFAF0;
        border-radius: 10px;
        border: 4px double #778899;
        color: #778899;
        text-align: center;
        font-size: 15px;
        padding: 10px;
        width: 100px;
        -webkit-transition: all 0.5s;
        -moz-transition: all 0.5s;
        -o-transition: all 0.5s;
        transition: all 0.5s;
        cursor: pointer;
        margin: 5px;
        font-family: 'Times New Roman', Times, serif;
}


#forum-body {
    margin: 0;
    padding: 0;
    width: 100vw;
    height: 100vh;  
    display: flex;
}

#forum-body-left {
    width: 35%;
    border-right: 1px solid #778899;
}

#forum-body-middle {
    width: 35%;
    border-right: 1px solid #778899;
}

#forum-body-right{
    width: 30%;
}

#steph-bio {
    margin-top: 100px;
    padding: 16px;
    text-align: center;
    background-color: #f1f1f1;
}

#upper-question{
    border-bottom: 1px solid #778899;
    width: 100%;
    height: 26%;
    background: #778899;
    text-align: center;
    margin: auto;
    padding-top: 30px;
    padding-bottom: 30px;
}

#bottom-forum{
    font-family: 'Times New Roman', Times, serif;
    height: 100%;
}

.question-card {
    border: 1px solid black;
    text-align: center;
    justify-content: center;
    width: 60%;
}

#pending-input {
    width: 80%;
    height: 40px;
    border: 4px double #778899;
}

* {
  box-sizing: border-box;
}

body {
  font-family: Arial, Helvetica, sans-serif;
}

/* Float four columns side by side */
.column {
  float: left;
  width: 25%;
  padding: 0 10px;
}

/* Remove extra left and right margins, due to padding */

/* Clear floats after the columns */

/* Responsive columns */
@media screen and (max-width: 600px) {
  .column {
    width: 100%;
    display: block;
    margin-bottom: 20px;
  }
}

/* Style the counter cards */
.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  padding: 30px;
  text-align: center;
  background-color: #f1f1f1;
}

</style>