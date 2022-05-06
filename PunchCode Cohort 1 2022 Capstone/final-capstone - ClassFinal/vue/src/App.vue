<template>
  <div id="app">
    <div id="nav">


      <router-link 
        class="home-button" 
        v-bind:to="{ name: 'home' }"
        v-if="$store.state.token != ''">
          Forum
      </router-link>&nbsp;&nbsp;
      
      <router-link 
        class="logout-button"
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''">
          Logout
      </router-link>&nbsp;&nbsp;

    </div>
    <router-view />
  </div>
</template>
<style>



</style>

