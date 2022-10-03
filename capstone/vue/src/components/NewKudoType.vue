<template>
  <body>
    <div class="newKudoTypes">
      <form v-on:submit.prevent action="submit" class="newKudoForm">
        <p>Create new Kudo Type</p>
        <label for="KudoName"
          >Kudo Type Name:
          <input id="KudoName" type="text" v-model="newKudoType.name" />
        </label>
        <label for="description"
          >Description:
          <input
            id="KudoDescription"
            type="text"
            v-model="newKudoType.description"
          />
        </label>
        <label for="value">Value:</label>
        <input id="value" type="number" v-model="newKudoType.value" />
        <button type="submit" v-on:click="saveKudoType()">Submit</button>
      </form>
    </div>
  </body>
</template>

<script>
import kudoService from "../services/KudosService";

export default {
  data() {
    return {
      newKudoType: {
        name: "",
        description: "",
        value: "",
      },
    };
  },
  methods: {
    saveKudoType() {
      kudoService.addKudoType(this.newKudoType).then((response) => {
        if (response.status === 201) {
          this.newKudoType.name = "";
          this.newKudoType.description = "";
          this.newKudoType.value = "";
        }
      });
      //     kudoService.getKudoTypes().then((response) =>{
      //     this.$store.commit("SET_KUDO_TYPES", response.data);
      //   })
    },
  },
};
</script>

<style>
.newKudoTypes {
  display: grid;
  justify-content: center;
  text-align: center;
  padding: 100px;
  margin: 100px;
  background-color: white;
}

body {
  background: linear-gradient(
    360deg,
    white,
    rgb(241, 197, 99),
    rgb(253, 223, 158),
    white
  );
}
p {
  font-weight: bold;
}
input {
  margin: 20px;
}
</style>