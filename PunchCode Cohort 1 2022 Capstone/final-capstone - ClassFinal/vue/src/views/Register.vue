<template>

<!-- HTML Code -->

  <body>




<!-- html -->
  <section id="left-panel">
    <header>
      <h1>Register</h1>
    </header>
    <h2>Women in tech will be the new norm</h2>
    <p>On this site, I share everything I've learnt about becoming a bullet
     proof female in tech (without sacrificing who you really are in the process)
</p>
 <h3>― Theodore Roosevelt</h3>
    <p>“Far better it is to dare mighty things, to win glorious triumphs, even though checkered by failure, than to 
      take rank with those poor spirits who neither enjoy much nor suffer much, because they live in the gray 
      twilight that knows neither victory nor defeat.”</p>








<!-- Register Code -->
 <div id="register" class="text-center">
   <form class="form-register" @submit.prevent="register">
     <!-- <h1 class="h3 mb-3 font-weight-normal">Create Account</h1> -->
     <div class="alert alert-danger" role="alert" v-if="registrationErrors">
       {{ registrationErrorMsg }}
     </div>
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
     <input
       type="password"
       id="confirmPassword"
       class="form-control"
       placeholder="Confirm Password"
       v-model="user.confirmPassword"
       required
     />
     <router-link :to="{ name: 'login' }">Have an account?</router-link>
     <button class="btn btn-lg btn-primary btn-block" type="submit">
       Create Account
     </button>
   </form>





   
   <!-- HTML -->
     <nav>
      <!-- <ul>
        <li><a href="https://www.linkedin.com/in/stephanysilva/">LinkedIn</a></li>
        <li><a href="https://www.instagram.com/stephyyylovee/">Instagram</a></li>
        <li><a href="mailto:Stephany@stephanysilva.com">Contact</a></li>
      </ul> -->
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
    </div>
  </section>

  <section id="right-panel">
    <div id="welcome">
      CyberSecurity
    </div>
  </section>




</body>
</template>










<script>
import authService from '../services/AuthService';
 
export default {
 name: 'register',
 data() {
   return {
     user: {
       username: '',
       password: '',
       confirmPassword: '',
       role: 'user',
     },
     registrationErrors: false,
     registrationErrorMsg: 'There were problems registering this user.',
   };
 },
 methods: {
   register() {
     if (this.user.password != this.user.confirmPassword) {
       this.registrationErrors = true;
       this.registrationErrorMsg = 'Password & Confirm Password do not match.';
     } else {
       authService
         .register(this.user)
         .then((response) => {
           if (response.status == 201) {
             this.$router.push({
               path: '/login',
               query: { registration: 'success' },
             });
           }
         })
         .catch((error) => {
           const response = error.response;
           this.registrationErrors = true;
           if (response.status === 400) {
             this.registrationErrorMsg = 'Bad Request: Validation Errors';
           }
         });
     }
   },
   clearErrors() {
     this.registrationErrors = false;
     this.registrationErrorMsg = 'There were problems registering this user.';
   },
 },
};
</script>
 


// CSS
<style>
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
    background-image: url('./comp.jpg');
    background-repeat: no-repeat;
    background-position: right;
    background-size: cover;
  }

h1,
  h2 {
    font-family: 'Kalam', cursive;
    margin: 0;
    text-align: center;
  }
  
  h1 {
    font-size: 5rem;
    background-color: lightslategray;
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
    background-color: lightslategray;
   font-family: 'Courier New', Courier, monospace;
   text-align: center;
   position: relative;
   top: 400px; left: 30px;
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



 
 
 

