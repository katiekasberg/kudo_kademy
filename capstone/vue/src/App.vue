<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      >
      <router-link
        v-bind:to="{ name: 'Teacher' }"
        v-if="$store.state.token != ''"
      >
        Teacher View
      </router-link>
      <router-link
        v-bind="{ name: 'SendKudos' }"
        v-if="$store.state.token != ''"
        >Send Kudos</router-link
      >
    </div>
    <router-view />
  </div>
</template>
