<template>
  <div>
    <img
      src="C:\Users\Student\workspace\school-communication-app-final-capstone\capstone\vue\resources\school-icon-9.png"
      alt=""
    />
    <nav><router-link>Home</router-link></nav>
    <form class="send-kudo">
      <h1 class="h3 mb-3 font-weight-normal">Send A Kudo!</h1>
      <label for="firstName" class="sr-only">First Name</label>
      <input
        type="text"
        id="firstName"
        class="form-control"
        placeholder="FirstName"
        v-model="user.firstName"
        required
        autofocus
      />
      <label for="lastName" class="sr-only">Last Name</label>
      <input
        type="text"
        id="lastName"
        class="form-control"
        placeholder="LastName"
        v-model="user.lastName"
        required
      />
      <input
        type="text"
        id="emailAddress"
        class="form-control"
        placeholder="EmailAddress"
        v-model="user.emailAddress"
        required
      />
      <input
        type="text"
        id="kudoType"
        class="form-control"
        placeholder="KudoType"
        v-model="user.kudoType"
        required
      />
      <input
        type="text"
        id="points"
        class="form-control"
        placeholder="Points"
        v-model="user.points"
        required
      />
      <input
        type="text"
        id="comment"
        class="form-control"
        placeholder="Comment"
        v-model="user.comment"
        required
      />
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Submit
      </button>
    </form>
  </div>
</template>

  <script></script>
    <style scoped>
.send-kudo {
  display: grid;
  align-items: center;
  justify-content: center;
  grid-gap: 7px;
}
</style>
  
