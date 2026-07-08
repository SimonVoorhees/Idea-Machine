export function getRandomArbitrary(min:number, max:number) {
  return Math.random() * (max - min) + min
}
export function getRandomColor() {
  switch (Math.floor(Math.random() * 16)) {
    case 0:
      return 'var(--cyan-dark)'
      break
    case 1:
      return 'var(--cyan-mid-dark))'
      break
    case 2:
      return 'var(--cyan)'
      break
    case 3:
      return 'var(--cyan-mid-light)'
      break
    case 4:
      return 'var(--cyan-light)'
      break
    case 5:
      return 'var(--blue-dark)'
      break
    case 6:
      return 'var(--blue-mid-dark)'
      break
    case 7:
      return 'var(--blue)'
      break
    case 8:
      return 'var(--blue-mid-light)'
      break
    case 9:
      return 'var(--blue-light)'
      break
    case 10:
      return 'var(--red-dark)'
      break
    case 11:
      return 'var(--red-mid-dark)'
      break
    case 12:
      return 'var(--red)'
      break
    case 13:
      return 'var(--red-light)'
      break
    case 14:
      return 'var(--orange-dark)'
      break
    case 15:
      return 'var(--orange-mid-dark)'
      break
    case 16:
      return 'var(--orange-light)'
      break

    default:
      return 'var(--blue)'
      break
  }
}