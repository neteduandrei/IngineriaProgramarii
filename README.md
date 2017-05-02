# IngineriaProgramarii
## Proiect

### Pentru fiecare modul trebuie facut cate un folder care la randul vostru il divizati cum  vreti (daca este necesar).

## Varianta cu branch work și Git Bash
Luati Git Bash si urmariti pasii:

* Creeaza un folder in care vei lucra

* Din Git Bash intra in folder

* Scrie in commander
```
git init #pentru crearea repositorului local in folder-ul vostru curent
git clone https://github.com/fistinflame/IngineriaProgramarii.git
git branch work #creeam un branch numit work
git checkout work #ne mutam pe branch-ul work si aici vom lucra de acuma incolo
```

* Pentru a adauga fisierele pe Github: (din branch-ul work)
```
git add . #adaugam tot din directorul nostru
git commit -m "Descriere a modificarilor" #aici git va face un pachet cu adaugarile noastre
git pull origin master #facem update la repository-ul local pe branch-ul master
git checkout master #schimbam branch-ul pe master
git merge work #combinam schimbarile noastre cu cele ale coechipierilor nostri. ATENTIE la merge conflicts!
git push origin master #adaugam modificarile noastre local si pe repository-ul oficial
git checkout work #schimbam inapoi pe branch-ul work si continuam sa facem schimbari
```

## Varianta cu branch work și GitKraken

#### Step 1
Create work branch and checkout.
![image](https://cloud.githubusercontent.com/assets/2271038/25617352/839c4d08-2f4a-11e7-979d-cb27e93b7e42.png)

#### Step 2
Do your work, make some commits...

#### Step 3
Right click on master branch and pull.
![image](https://cloud.githubusercontent.com/assets/2271038/25617380/a8b10980-2f4a-11e7-9be5-68eb89ac401c.png)


#### Step 4
Right click on master branch and checkout.
![image](https://cloud.githubusercontent.com/assets/2271038/25617391/bf1cdb54-2f4a-11e7-9f8d-aa0fa9787426.png)

#### Step 5
Right click on work branch, choose __merge work into master__
![image](https://cloud.githubusercontent.com/assets/2271038/25617439/fa437ecc-2f4a-11e7-9d94-debb4e41b9be.png)

Done. Credits to [valiro21](https://github.com/valiro21) for providing clear instructions on the process.
