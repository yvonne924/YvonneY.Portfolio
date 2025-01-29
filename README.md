# Yeung Lai_Yvonne.Portfolio
# Business Data Analysis

## About
Hi, my name is Yeung Lai, but you can call me Yvonne. I'm originally from Hong Kong and moved to Japan in 2022. Currently, I am pursuing a Master’s degree in Information Technology at Kyoto, where I’m focusing on business data science. With over five years of experience in marketing and production, I have honed a results-oriented approach to achieving business goals.

I’ve developed technical expertise in machine learning algorithms, Python, and data visualization through academic projects and my role as a teaching assistant. Additionally, my proven cross-cultural communication skills were demonstrated through translation work with Shiseido, highlighting my ability to adapt to diverse environments.

I combine my marketing experience—understanding business objectives and customer needs—with technical proficiency in Python, SQL, and data visualization tools to extract meaningful insights from complex datasets. I am excited about exploring new opportunities where I can leverage my blend of marketing insights and data science expertise to drive business performance. I’m open to new challenges and welcome opportunities to relocate for the right role.

Find my CV in [Here]([YeungLai_Yvonne_CV.pdf](https://github.com/yvonne924/YvonneY.Portfolio/blob/aa23578d8504fe9ddefa611148826b6a9ecea84e/YeungLai_Yvonne_CV.pdf))

## Project of Contents
  - [Python Projects](#python-projects)
    - [A/B Testing on Website Theme](#a/b-testing)
    - [Insurance Cross-Sell Analysis](#insurance-cross-sell-analysis)
    - [Loan Approval Prediction Analysis](#loan-approval-prediction)
  - [MySQL Projects](#sql-projects)
    - [Analyzing Students' Mental Health](#analyzing-students'-mental-health)
  - [R Projects](#r-projects)
    - [Sleep Health and Lifestyle Analysis (Study Project)](#sleep-health-and-lifestyle-analysis-studt-project)
  - [Excel/Power BI Projects](#excel/power-bi-projects)
    - [Coffee shop Sales Dashboard](#coffee-shop-sales-dashboard)
    - [Grocery Data Dashboard in Power BI](#grocery-data-dashboard-in-power-bi)
  - [Tableau Projects](#tableau-projects)
    - [Netflix Data Dashboard](#netflix-data-dashboard)
  - [IntelliJ IDEA(Java)](#intellij-idea(java))
    - [Fitness tracking system](#fitness-tracking-system)
  - [Certificates](#certificates)
  - [Contacts](#contacts)

### Python Projects

In this section, I will list the data analytics projects I have completed using Python.

### A/B Testing 

- **Code**:[A/B Testing on Website Theme](https://github.com/yvonne924/YvonneY.Portfolio/blob/3d40612d87d940309a6b0144bd59dfea9234d419/Python/AB%20test.ipynb)
- **Goal**: To determine which website design theme ("Light Theme" or "Dark Theme") performs better target to engaging users and increasing book purchases.
- **Description**: In this Project we are using A/B testing to compare user behavior across two themes of an online bookstore's website. Key performance metrics, including Click-Through Rate (CTR), Conversion Rate, Bounce Rate, Scroll Depth, and Session Duration, were analyzed to identify which theme encourages greater user engagement and purchasing activity.
- **Skills**:
• Data Analysis
• Statistical Testing (e.g., z-tests)
• Data Visualization (e.g., scatter plots, violin plots, and KDE plots)
• Python Programming for data manipulation and visualization
- **Technology**:
• Libraries: Python library, Pandas, Plotly, Statsmodels, Seaborn, Matplotlib
• Tools: Jupyter Notebook
- **Results**: The Light Theme slightly outperformed the Dark Theme in purchases and cart additions, with conversion rates of 53.09% (Light) and 50.39% (Dark). However, statistical analysis (p-value = 0.394) indicated that these differences were not significant, suggesting that the observed performance variation could be due to random chance.
![image](https://github.com/yvonne924/YvonneY.Portfolio/blob/6b8e9c87375052466933f5817feb9a556bbf154a/img/AB%20testing.png)


### Insurance Cross-Sell Analysis

- **Code**:[Insurance Cross-Sell Analysis](https://github.com/yvonne924/YvonneY.Portfolio/blob/07077b13d0f2077f817d575ea1c83d6ac23ad833/Python/insurance-cross-analysis-xgboost-catboost.pdf)
- **Goal**: To predict which customers respond positively to an automobile insurance offer. 
-  **Description**: This notebook focuses on evaluating the performance of a predictive model using the Area Under the Receiver Operating Characteristic Curve (AUC-ROC). Utilized machine learning techniques XGBoost and CatBoost to evaluate predictive models. The aim was to identify high-potential customers.
- **Skills**:
  •Data Preprocessing (handing missing values, scaling, feature selection)
  •Exploratory Data Analysis (EDA)
  •Machine Learning Model Development (XGBoost, CatBoost)
  •Model Evaluation (ROC-AUC, accuracy metrics)
- **Technology**:
  •	Python (Libraries: Pandas, NumPy, Scikit-learn, Matplotlib, Seaborn)XGBoost and CatBoost libraries for model building
  •	Result 
  •	Achieved a highly accurate predictive model, with ROC-AUC scores indicating strong discriminatory power.
  •	Identified key features influencing cross-sell probability, such as customer age, previous policies held, and tenure.
  •	Delivered actionable insights to guide marketing teams, improving the efficiency of cross-selling campaigns.

### Loan Approval Prediction Analysis

- **Code**: [Loan Approval Prediction Analysis](https://github.com/yvonne924/YvonneY.Portfolio/blob/1de1c8da1458ddcd2897d2b6636f377d7993bf27/Python/Loan%20Approval%20Prediction%20Analysis.ipynb)
- **Goal**: To build a predictive model that determines the likelihood of loan approval for applicants, assisting financial institutions in automating and improving decision-making processes.
-  **Description**: Analyzed historical loan application data to identify patterns and factors affecting loan approval rates. The project included data cleaning, feature engineering, and applying machine learning algorithms to predict loan approval outcomes. 
- **Skills**:
  •	Data Cleaning (handling missing values, encoding categorical variables)
  •	Exploratory Data Analysis (EDA)
  •	Machine Learning Model Development (Logistic Regression, Decision Trees, Random Forest)
  •	Model Evaluation (Confusion Matrix, Accuracy, Precision, Recall, F1-Score)
- **Technology**:
  •Python (Libraries: Pandas, NumPy, Scikit-learn, Matplotlib, Seaborn)
  •Jupyter Notebook for analysis and prototyping
- **Results**: XGBoost is the best performing overall, with the highest accuracy 0.95.

### SQL Projects

### Analyzing Students' Mental Health 

- **Code**: [Analyzing Students' Mental Health](https://github.com/yvonne924/YvonneY.Portfolio/blob/b4d12f41ab22d8f493785b06387fd02ef025159b/SQL/Analyzing%20Students'%20Mental%20Health.ipynb)
- **Goal**:Understand the impact of studying in a foreign country on the mental health of international students, focusing on the relationships between depression, social connectedness, acculturative stress, and length of stay using survey data from Japanese international university. 
-  **Description**: xplored a dataset of 286 student records, containing variables such as depression scores (PHQ-9), social connectedness scores (SCS), acculturative stress scores (ASISS), language proficiency, and length of stay. Used PostgreSQL to clean the data, calculate summary statistics, and investigate relationships between variables. Conducted further analysis to compare international and domestic students' mental health outcomes and examined how factors such as age, length of stay, and language proficiency influenced acculturative stress and depression.
- **Skills**:
  •	Data cleaning and preprocessing
  •	Statistical analysis and hypothesis testing
  •	Data querying and exploration using SQL
  •	Data visualization and interpretation
- **Technology**:
  •	PostgreSQL for querying and analyzing the dataset
  •	Python for creating interactive visualizations (Plotly) and heatmaps
  •	Statistical methods (e.g., calculating correlations and summary statistics)
- **Results**: The analysis confirmed that international students face higher risks of depression compared to domestic students. Social connectedness and acculturative stress were found to be predictive of depression, supporting the original study's findings. However, length of stay did not significantly affect mental health outcomes. Additionally, higher Japanese proficiency correlated with lower acculturative stress, but intermediate proficiency levels did not guarantee significant stress reduction. The findings highlight the complexity of factors affecting international students' mental health.

### R Projects

### Sleep Health and Lifestyle Analysis (Study Project)
- **Code**:[Sleep Health and Lifestyle Analysis (Study Project)](https://github.com/yvonne924/YvonneY.Portfolio/blob/0ac666382b3f538040fd2646f98a8256ae96423d/R/Sleep%20Health%20and%20Lifestyle%20Dataset_2.pdf)

- **Goal**: To investigate the relationship between physical activity levels and sleep quality using the “Sleep Health and Lifestyle” dataset, and to validate hypotheses through statistical analysis and data visualization. 
-  **Description**:Analyzed a dataset containing 374 subjects with 13 variables, including sleep duration, quality of sleep, physical activity levels, stress levels, BMI category, and presence of sleep disorders. Conducted correlation analysis, statistical tests and created visualizations to explore the impact of physical activity on sleep quality.
- **Skills**:
  •	Data analysis and hypothesis testing 
  •	Statistical modeling and interpretation 
  •	Data visualization and exploratory analysis 
- **Technology**:
  •	R Programming (ggplot2, tidyverse, viridisLite)
  •	Statistical tools for correlation and non-parametric testing
  •	Data visualization libraries
- **Results**: Validated the hypothesis that there is a significant positive correlation between daily physical activity levels and sleep quality. Found that while increased physical activity correlates positively with sleep quality, excessive activity can negatively impact it. Developed insights into the relationship between lifestyle habits and sleep health, supporting further research opportunities.

### Excel/Power BI Projects

### Coffee shop Sales Dashboard
- **Code**:[Coffee shop Sales Dashboard](https://github.com/yvonne924/YvonneY.Portfolio/blob/64c305d49a9fead70fbb9b73a18ebe9c0cde065c/Excel/Coffee%20Shop%20Sales.xlsx)

### Grocery Data Dashboard in Power BI
- **Demonstrate Video**: [Grocery Data Dashboard in Power BI](https://github.com/yvonne924/YvonneY.Portfolio/tree/6bd0435745cd9e9cd6204b52904a6c1200f70bf1/Excel/Grocery%20Data%20analysis)
### Hostital Emergency Room Dashboard Dashboard in Power BI
**Demonstrate Video**:
- **Goal**: 
To enhance operational, efficiency and provide actionable insight into emergency room performance, by created
the dashboard will enable stakeholders to track, analyze, and data-driven decisions regarding patient management and service optimization. 
- **About the dataset**:
The emergency room dataset, covering a period of 19 months, records total of 9,216 unique patients. The dataset included patients’ basic information like name, age, gender and race also included wait time admission status and satisfaction score to identify the hospital emergency room performance. 
- **Key insight**:
The Average wait time was approximately 35.3 minutes, Average satisfaction score was 4.99 out of 10. 
The peak busiest period is on Saturday (1368) and Sunday (1361). The busiest hours were 13-14, 15-16, suggest we need to have more staff on duty to reduce the pressure of understaff.
Age Groups: Adults (30 - 39 Years formed a large group (1200 Patients), followed by young adults (20 - 29 Years) with 1188 patients. 
- **Summary**:
The dataset reveals high patient volumes, moderate satisfaction levels, and common referrals to General Practice and Orthopedics. Saturday and Sunday are particularly busy. The patient demographics show a diverse age and racial composition, with nearly equal numbers of admitted and non-admitted patients. These insights can help optimize resource allocation and improve patient care in the emergency room.

### Tableau Projects

### Netflix Data Dashboard
- **Code**:[Netflix project](https://public.tableau.com/views/Netflix_17361456597660/Dashboard1?:language=en-GB&publish=yes&:sid=&:redirect=auth&:display_count=n&:origin=viz_share_link)

### IntelliJ IDEA(Java)
### Fitness tracking system
- **Code**:[Fitness tracking system](https://github.com/yvonne924/YvonneY.Portfolio/tree/b40b255c26e68a3b89d60c424714cf0e64f1d1d4/Java) 

## Certificates
- [Google Cloud Data Analytics Certificate](https://www.credly.com/badges/9e45beff-20ba-4502-ac12-b7bad6df5330)(Jan 2025)(Google Cloud)
- [AWS Certified Cloud Practitioner](https://aws.amazon.com/verification) (number: 83e3e72ad706488d9c7c84997807427b) (Sep 2024)(Amazon - AWS)
- [Excel Skills for Data Analytics and Visualization](https://coursera.org/share/a2e8bc4bffdf10f7a8ed8122e4262cba) (Oct 2024) (Coursera - Macquarie University, Sydeny Australia)
- [IBM Data Science](https://coursera.org/share/26da54d37dc8e22641a8195025d5b7f4) (May 2024) (Coursera - IBM)

## Contacts
- LinkedIn: [@yvonne-yeung-lai](https://www.linkedin.com/in/yvonne-yeung-lai/)
- Email: yvonneyeungjp@gmail.com
