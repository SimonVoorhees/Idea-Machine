<script setup>
import { ref } from 'vue'
import axios from 'axios'
import IdeaGroup from './IdeaGroup.vue'

const ideas = ref([])
const getNumber = async (amount) => {
  try {
    const response = await axios.get(`http://127.0.0.1:8080/${amount}`)
    ideas.value = response.data
  } catch (error) {
    console.log(error)
  }
}
const getGroups = async (groups, amountPerGroup) => {
  try {
    const response = await axios.get(`http://127.0.0.1:8080/${groups}/${amountPerGroup}`)
    ideas.value = response.data
  } catch (error) {
    console.log(error)
  }
}
const onSubmit = (e) => {
  getGroups(e.target.groups.value, e.target.amountPerGroup.value)
}
</script>

<template>
  <h1 class="Title">Simon's Idea Machine</h1>
  <form @submit.prevent="onSubmit" class="IdeaForm">
      <section class="IdeaForm-Section">
        <label class="IdeaForm-Label">Groups</label>
        <input type="text" name="groups" class="IdeaForm-Input" required />
      </section>
      <section class="IdeaForm-Section">
        <label class="IdeaForm-Label">Ideas</label>
        <input
          type="text"
          name="amountPerGroup"
          class="IdeaForm-Input"
          label="Amount Per Group"
          required
        />
      </section>
      <button type="submit" class="IdeaForm-Button">Ready!</button>
  </form>
  <section class="IdeaGroups-Container">
    <IdeaGroup v-for="group in ideas" :group="group" />
    <!-- <IdeaList v-if="ideas.length > 0" :ideas="ideas" /> -->
  </section>
</template>

<style>
.Title {
  font-family: laff-riot-nf-font;
  font-size: 72px;
  background-color: var(--orange);
  border: 24px solid var(--blue);
  color: var(--blue);
  margin-bottom: 32px;
  width: 480px;
  text-align: center;
  font-weight: 900;
  transform: skew(20deg);
}
.IdeaForm {
  background-color: var(--orange);
  padding: 16px 10%;
  font-family: yokelvision-font;
  font-size: 32px;
  display: flex;
  flex-direction: row;
  width: 100%;
  align-items: flex-end;
}
.IdeaForm-Section {
    display: flex;
    flex-direction: column;
    width: 100%;
    align-items: flex-end;
    margin-right: 16px;
}
.IdeaForm-Label {
  color: var(--blue);
  font-size: 48px;
  text-align: right;
  text-wrap: nowrap;
}
.IdeaForm-Input {
  margin-right: 12px;
  background-color: var(--blue);
  color: var(--orange);
  font-size: 32px;
  padding: 16px 16px 16px 32px;
  border: none;
  width:85px;
  border-radius: 128px 256px;
}
.IdeaForm-Button {
  background-color: var(--orange);
  color: var(--blue);
  border: none;
  font-size: 64px;
  font-weight: 900;
  height: 100%;
  padding-bottom: 0px;
  margin-bottom: -24px;
  margin-left: 32px;
  width: 100%;
  z-index:3;
  font-family: yokelvision-font;
}
.IdeaForm-Button:hover{
  color: var(--orange);
  background-color: var(--blue);
  border-radius: 128px 256px;
  font-family: laff-riot-nf-font;
}
.IdeaForm-Button:active{
  background-color: var(--orange) !important;
  color: var(--blue)  !important;
  border-radius: 128px 256px;
  font-family: laff-riot-nf-font;
}
.IdeaGroups-Container {
  background-color: var(--orange);
  color: var(--blue);
  margin: 0;
  padding: 8px;
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
}
</style>
