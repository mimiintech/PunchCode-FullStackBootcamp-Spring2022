<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      >
      <div class="loggedNav" v-if="$store.state.token != ''">
        <router-link :to="{ name: 'display' }"
          >[ List All Puppies ]</router-link
        >
        |
        <router-link :to="{ name: 'add' }">[ Add Puppies ]</router-link>
        <router-link :to="{ name: 'delete' }">[ Delete Puppy ]</router-link>
      </div>
    </div>
    <router-view />
  </div>
</template>

<style scoped>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
}
#nav {
  padding: 30px;
}
.loggedNav {
  text-align: center;
}
</style>
