import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sb
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler
from sklearn.linear_model import LogisticRegression
from sklearn.svm import SVC
# from xgboost import XGBClassifier
from sklearn import metrics


df = pd.read_csv('TATASTEEL.NS.csv')
print(df)

plt.figure(figsize=(15,5))
plt.plot(df['Close'])
plt.title('Tata steel limited Close price.', fontsize=15)
plt.ylabel('Price in dollars.')
plt.show()


splitted = df['Date'].str.split('-', expand=True)

df['day'] = splitted[1].astype('int')
df['month'] = splitted[0].astype('int')
df['year'] = splitted[2].astype('int')
df['is_quarter_end'] = np.where(df['month']%3==0,1,0)
df.head()
print(df)