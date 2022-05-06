<template>
  <body>




<!-- html -->
  <section id="left-panel">
    <header>
      <h1>Hi, I'm Stephany</h1>
    </header>
    <h2>Information Security Analyst</h2>
    <p>Hi, I am Stephany. I am an internet entrepreneur, Information Security professional, 
      and passion for empowering women in tech to become an unstoppable force.</p>
    <p>I am obsessed with mastering every area of my life, fulfilling my potential and 
      leaving the world a better place than what I found it. </p>






    <!-- Login code goes here -->

      <div id="login" class="text-center">
    <form class="form-signin" @submit.prevent="login">
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <button type="submit">Sign in</button>
      
       <router-link :to="{ name: 'register' }">Sign Up</router-link>
      
    </form>
  </div>


<!-- HTML -->
     <nav>
      <ul>
        <li><a href="https://www.linkedin.com/in/stephanysilva/">LinkedIn</a></li>
        <li><a href="https://www.instagram.com/stephyyylovee/">Instagram</a></li>
        <li><a href="mailto:Stephany@stephanysilva.com">Contact</a></li>
      </ul>
    </nav>
    <footer>
      <ul class="social-icons">
        <li><a href="#"><i class="fab fa-facebook fa-3x"></i></a></li>
        <li><a href="#"><i class="fab fa-instagram fa-3x"></i></a></li>
        <li><a href="#"><i class="fab fa-twitter fa-3x"></i></a></li>
        <li><a href="#"><i class="fab fa-pinterest fa-3x"></i></a></li>
        <li><a href="#"><i class="fab fa-behance fa-3x"></i></a></li>
      </ul>
    </footer>
  </section>

  <section id="right-panel">
    <div id="welcome">
      Welcome to my site
    </div>
  </section>



     <!-- Login code goes here -->
</body>
</template>

<script>
import authService from "../services/AuthService";

export default {
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>





// css
<style scoped>

/* @import 'style.css';

@include .text-center; */

body {
    margin: 0;
    padding: 0;
    height: 400;
    flex-direction: row;
    display: flex;
  }
  
  #left-panel {
    background-color: #F7F7F7;
    flex-direction: column;
    display: flex;
    width: 35%;
  }
  
  ul.social-icons {
    list-style-type: none;
    margin: 20px 20px;
    padding: 0;
    flex-direction: row;
    display: flex;
    justify-content: space-between;
  }
  
  nav {
    flex-direction: row;
    display: flex;
    flex-grow: 2;
  }
  
  #right-panel {
    display: flex;
    align-items: center;
    justify-content: center;
    flex-grow: 3;
    background-image: url('./stephany.jpg');
    background-repeat: no-repeat;
    background-position: right;
    background-size: cover;
  }






  /* This area is for the login  */

  #login{
    font-weight: bolder;
  }

.sr-only {
  font-family: 'Times New Roman', Times, serif;
}
   
   
   
   
   
   
   
   
   
   /* CSS */
   /* This area is for the login  */
  
  /* YOU WON'T NEED TO CHANGE ANY STYLES BELOW THIS LINE */
  
  h1,
  h2 {
    font-family: 'Kalam', cursive;
    margin: 0;
    text-align: center;
  }
  
  h1 {
    font-size: 5rem;
     background-color: #F2CC65;
  }
  
  h2 {
    font-size: 2rem;
    font-weight: 400;
    margin: 20px 0;
  }
  
  header {
    background-color: #F2CC65;
  }
  
  p {
    font-family: 'Times New Roman', Times, serif;
    font-weight: 300;
    font-size: 1.1rem;
    line-height: 2.1rem;
    padding: 0 20px;
    font-weight:300;
  }
  
  nav ul {
    list-style-type: none;
    margin: 0 20px 0 20px;
    padding: 0;
  }
  
  nav ul li {
    font-family: cursive;
    font-size: 2rem;
    font-weight: 400;
    text-transform:capitalize;
    border-bottom: 1px solid #707070;
    padding-top: 30px
  }
  
  nav a,
  nav a:visited {
    text-decoration: none;
    color: #1b1b1b;
  }
  
  nav a:hover {
    color: #F2CC65;
    padding-left: 5px;
  }
  
  .fab {
    color: #3A3B00
  }
  
  .social-icons li a:hover .fab {
    color: #F2CC65
  }
  
  #welcome {
    background-color: #F2CC65;
    font-family: 'Kalam', cursive;
    text-align: center;
    position: relative;
    top: 300px; left: 30px;
    font-size: 5rem;
    padding: 20px;
    border-radius: 10px;
  }
  
  @media(max-width: 1024px) {
  
    h1,
    #welcome {
      font-size: 3rem;
    }
  
    h2 {
      font-size: 1.4rem;
    }
  
    .fa-3x {
      font-size: 1.5rem;
    }
  }
  
  @media(max-width: 425px) {
    #left-panel {
      flex-basis: 100%;
    }
  
    nav ul li {
      font-size: 1rem;
    }
  
    ul.social-icons {
      margin-top: 40px;
    }
  
    #right-panel {
      display: none;
    }
  }

</style>


