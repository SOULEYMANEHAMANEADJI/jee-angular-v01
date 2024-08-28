# Application de Gestion Web avec Angular et Jakarta EE

## Description

Ce projet est une application web de gestion qui utilise Angular pour le frontend et Jakarta EE pour le backend. L'application permet de gérer des utilisateurs, des produits, des marques et des catégories. Elle inclut également des fonctionnalités pour l'exportation de données en PDF et Excel, ainsi que l'affichage de graphiques interactifs avec Chart.js.

## Prérequis

- **Node.js** : v18.19.1 ou supérieur
- **NPM** : v8 ou supérieur
- **Angular CLI** : v18

## Installation

1. **Cloner le projet** :
   ```bash
   git clone https://votre-url-de-depot.git
   cd frontend-app
   ```

2. **Installer les dépendances** :
   ```bash
   npm install
   ```

3. **Lancer l'application** :
   ```bash
   ng serve
   ```

   Accédez à l'application via [http://localhost:4200](http://localhost:4200).

## Fonctionnalités

- **Gestion des utilisateurs et produits** : CRUD complet pour les utilisateurs et produits.
- **Exportation** : Génération de fichiers PDF et Excel.
- **Graphiques dynamiques** : Visualisation de données avec Chart.js.

## Structure

- **Services** :
  - `PdfService` : Génération de fichiers PDF.
  - `ExcelService` : Génération de fichiers Excel.
  - `UserService` et `ProductService` : Gestion des utilisateurs et des produits.

- **Composants** :
  - `UserListComponent` : Liste des utilisateurs.
  - `ProductListComponent` : Liste des produits.
  - `DashboardComponent` : Tableau de bord avec graphiques.

## Auteur

Développé par Mine HAS pour un projet de gestion web avec Angular et Jakarta EE.
