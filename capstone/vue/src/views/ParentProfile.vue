<template>
  <div>
    <div class="parent-profile">
        <h1>Parent Profile</h1>
        <div>
            <p id="first-name">First Name: {{ this.$store.state.activeStudentProfile.firstName }} </p>
            <p id="last-name">Last Name: {{ this.$store.state.activeStudentProfile.lastName }} </p>
            <p id="school">School: {{ this.$store.state.activeStudentProfile.schoolId }} </p>
            <p id="graduation-year">Class Of: {{ this.$store.state.activeStudentProfile.graduationYear }} </p>
            <p id="email">Email Address: {{ this.$store.state.activeStudentProfile.email }} </p>
            <img v-bind:src="this.$store.state.activeStudentProfile.image"/>
        </div>
    </div>
  </div>
</template>

<script>
export default {

}
</script>

<style>

</style>